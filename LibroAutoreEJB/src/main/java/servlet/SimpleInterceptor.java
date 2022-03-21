package servlet;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Interceptor
public class SimpleInterceptor {
	
	@Inject
	ProcessTracker processTracker;
	
	@AroundInvoke
	public Object aroundInvoke(InvocationContext context) throws Exception {
		context.getMethod();
		processTracker.track();
		return context.proceed();
		
	}

}
