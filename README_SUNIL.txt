Internationalization on Category
1)DispatcherServlet change

<mvc:interceptors>
		<bean class="org.springframework.web.servlet.i18n.LocaleChangeInterceptor">
			<property name="paramName" value="language" />
		</bean>
	</mvc:interceptors>

	<bean id="localeResolver"
		class="org.springframework.web.servlet.i18n.SessionLocaleResolver">
		<property name="defaultLocale" value="en_US" />
	</bean>
	
2) add message property file in resources.