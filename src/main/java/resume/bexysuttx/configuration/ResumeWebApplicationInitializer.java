package resume.bexysuttx.configuration;

import org.sitemesh.builder.SiteMeshFilterBuilder;
import org.sitemesh.config.ConfigurableSiteMeshFilter;
import org.springframework.orm.jpa.support.OpenEntityManagerInViewFilter;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.filter.RequestContextFilter;
import org.springframework.web.servlet.DispatcherServlet;
import resume.bexysuttx.filter.ResumeFilter;
import resume.bexysuttx.listener.ApplicationListener;

import javax.servlet.*;
import java.util.EnumSet;



public class ResumeWebApplicationInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext container) throws ServletException {
		WebApplicationContext ctx = createWebApplicationContext(container);

		container.setSessionTrackingModes(EnumSet.of(SessionTrackingMode.COOKIE));
		container.addListener(new ContextLoaderListener(ctx));
		container.addListener(ctx.getBean(ApplicationListener.class));

		registerFilters(container, ctx);
		registerSpringMVCDispatcherServlet(container, ctx);
	}

	private WebApplicationContext createWebApplicationContext(ServletContext container) {
		AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
		ctx.scan("resume.bexysuttx.configuration");
		ctx.setServletContext(container);
		ctx.refresh();
		return ctx;
	}

	private void registerFilters(ServletContext container, WebApplicationContext ctx) {
		registerFilter(container, ctx.getBean(ResumeFilter.class));
		registerFilter(container, new CharacterEncodingFilter("UTF-8", true));
		registerFilter(container, new OpenEntityManagerInViewFilter());
		registerFilter(container, new RequestContextFilter());
		registerFilter(container, new DelegatingFilterProxy("springSecurityFilterChain"), "springSecurityFilterChain");
		registerFilter(container, buildConfigurableSiteMeshFilter(), "sitemesh");
	}

	private void registerFilter(ServletContext container, Filter filter, String... filterNames) {
		String filterName = filterNames.length > 0 ? filterNames[0] : filter.getClass().getSimpleName();
		container.addFilter(filterName, filter).addMappingForUrlPatterns(null, true, "/*");
	}

	private void registerSpringMVCDispatcherServlet(ServletContext container, WebApplicationContext ctx) {
		ServletRegistration.Dynamic servlet = container.addServlet("dispatcher", new DispatcherServlet(ctx));
		servlet.setLoadOnStartup(1);
		servlet.addMapping("/");
	}

	private ConfigurableSiteMeshFilter buildConfigurableSiteMeshFilter() {
		return new ConfigurableSiteMeshFilter() {
			@Override
			protected void applyCustomConfiguration(SiteMeshFilterBuilder builder) {
				builder.addDecoratorPath("/*", "/WEB-INF/template/page-template.jsp").addDecoratorPath("/fragment/*",
						"/WEB-INF/template/fragment-template.jsp");
			}
		};
	}
}