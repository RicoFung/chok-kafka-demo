package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;

import com.kafka.provider.Sender;

@SpringBootApplication
public class Application extends SpringBootServletInitializer
{
	public static void main(String[] args)
	{

		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);

		Sender sender = context.getBean(Sender.class);

		for (int i = 0; i < 3; i++)
		{
			// 调用消息发送类中的消息发送方法
			sender.send();

			try
			{
				Thread.sleep(3000);
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application)
	{
		return application.sources(Application.class);
	}
}
