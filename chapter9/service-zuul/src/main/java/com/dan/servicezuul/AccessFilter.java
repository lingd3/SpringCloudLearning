package com.dan.servicezuul;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

@Component
public class AccessFilter extends ZuulFilter {
	
	private static Logger log = Logger.getLogger(AccessFilter.class);
	
	/*
	 * filterType: 过滤器的类型，它决定过滤器在请求的哪个生命周期中执行。
	 * pre：路由之前 routing：路由之时 post：路由之后 error：发送错误调用 
	 */
	@Override
	public String filterType() {
		return "pre";
	}
	
	/*
	 * filterOrder：过滤器的执行顺序。当请求在一个阶段中存在多个过滤器时，需要根据该方法返回的值来一次执行。
	 */
	@Override
	public int filterOrder() {
		return 0;
	}
	
	/*
	 * shouldFilter：判断该过滤器是否需要被执行。
	 * 这里可以写逻辑判断，是否要过滤，这里true, 永远过滤。
	 */
	@Override
	public boolean shouldFilter() {
		return true;
	}

	/*
	 * run：过滤器的具体逻辑。可以很复杂，包括查sql，nosql去判断该请求到底有没有权限访问。
	 */
	@Override
	public Object run() {
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		log.info(String.format("%s >>> %s", request.getMethod(), request.getRequestURL().toString()));
		Object accessToken = request.getParameter("token");
		if (accessToken == null) {
			log.warn("token is empty");
			ctx.setSendZuulResponse(false);
			ctx.setResponseStatusCode(401);
			try {
				ctx.getResponse().getWriter().write("token is empty");
			} catch (Exception e) {
			}

			return null;
		}
		log.info("ok");
		return null;
	}

}
