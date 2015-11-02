package com.va.reservation.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import com.va.reservation.domain.Reservation;
import com.va.reservation.repository.ReservationByMonthRespository;
import com.va.reservation.repository.redis.RedisReservationByMonthRepository;
import com.va.reservation.repository.redis.RedisReservationRepository;

@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.va.reservation"})
//@EnableAspectJAutoProxy(proxyTargetClass = true)
//@ComponentScan(basePackages = { "org.cloudfoundry.samples.crawler" })
public class AppConfig {
	
	@Bean
	public RedisReservationRepository redisRepository(
			RedisTemplate<String, Reservation> redisTemplate) {
		return new RedisReservationRepository(redisTemplate);
	}

	@Bean
	public ReservationByMonthRespository reservationByMonthRepository(
			StringRedisTemplate redisTemplate) {
		return new RedisReservationByMonthRepository(redisTemplate);
	}

	@Bean
	public StringRedisTemplate stringRedisTemplate(
			RedisConnectionFactory redisConnectionFactory) {
		StringRedisTemplate stringRedisTemplate = new StringRedisTemplate(
				redisConnectionFactory);

		return stringRedisTemplate;

	}

	@Bean
	public RedisTemplate<String, Reservation> redisTemplate(
			RedisConnectionFactory redisConnectionFactory) {
		RedisTemplate<String, Reservation> template = new RedisTemplate<String, Reservation>();
		template.setConnectionFactory(redisConnectionFactory);
		RedisSerializer<String> stringSerializer = new StringRedisSerializer();
		RedisSerializer<Reservation> reservationSerializer = new Jackson2JsonRedisSerializer<Reservation>(
				Reservation.class);
		template.setKeySerializer(stringSerializer);
		template.setValueSerializer(reservationSerializer);
		template.setHashKeySerializer(stringSerializer);
		template.setHashValueSerializer(reservationSerializer);
		return template;
	}
//	@Autowired
//	private Environment environment;

//	@Bean
//	Environment env() {
//		return new Environment();
//
//	}

//	@Bean
//	public ObjectMapper customMapper() {
//		ObjectMapper mapper = new ObjectMapper();
//		mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
//		return mapper;
//	}

//	@Bean
//	Reactor rootReactor(Environment env) {
//		return Reactors.reactor().env(env).dispatcher(Environment.THREAD_POOL)
//				.get();
//	}

//	@Bean
//	public MessageListener<Page> listener(Reactor reactor) {
//		return new AmqpMessageListener(reactor);
//	}

//	@Bean
//	public RabbitAdmin admin(ConnectionFactory connection) {
//		RabbitAdmin admin = new RabbitAdmin(connection);
//		return admin;
//	}
//
//	@Bean
//	@Autowired
//	public RabbitTemplate template(ConnectionFactory cf) {
//		return new RabbitTemplate(cf);
//	}

//	@Bean(name = "messageContainer")
//	@DependsOn(value = "channelConfigurer")
//	public SimpleMessageListenerContainer messageContainer(
//			MessageListener<Page> listener, RabbitAdmin admin,
//			ConnectionFactory connection) {
//		SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
//		container.setConnectionFactory(connection);
//		container.setMessageListener(new MessageListenerAdapter(listener,
//				"onMessage"));
//		container.setQueueNames(Constants.PAGE_WORKER_QUEUE);
//		return container;
//	}

//	@Bean
//	public HttpClient client() {
//		return HttpClients.createDefault();
//	}

}
