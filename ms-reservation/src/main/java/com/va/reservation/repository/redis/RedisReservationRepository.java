package com.va.reservation.repository.redis;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.va.reservation.domain.Reservation;
import com.va.reservation.repository.ReservationRepository;

//@RepositoryRestResource(collectionResourceRel = "reservation", path = "reservation")
public class RedisReservationRepository implements ReservationRepository {

	private final HashOperations<String, String, Reservation> hashOps;

	public static final String RESERVATIONS_KEY = "reservations";

	public RedisReservationRepository(
			RedisTemplate<String, Reservation> redisTemplate) {
		this.hashOps = redisTemplate.opsForHash();
		// this.idGenerator = new RandomIdGenerator();
	}

	@Override
	public <S extends Reservation> S save(S Reservation) {
		
		hashOps.put(RESERVATIONS_KEY, Reservation.getId(), Reservation);
		return Reservation;
	}

	@Override
	public <S extends Reservation> Iterable<S> save(Iterable<S> Reservations) {
		List<S> result = new ArrayList<S>();
		for (S entity : Reservations) {
			save(entity);
			result.add(entity);
		}
		return result;
	}

	@Override
	public Reservation findOne(String id) {
		return hashOps.get(RESERVATIONS_KEY, id);
	}

	@Override
	public boolean exists(String id) {
		return hashOps.hasKey(RESERVATIONS_KEY, id);
	}

	@Override
	public Iterable<Reservation> findAll() {
		return hashOps.values(RESERVATIONS_KEY);
	}

	@Override
	public Iterable<Reservation> findAll(Iterable<String> ids) {
		return hashOps.multiGet(RESERVATIONS_KEY, convertIterableToList(ids));
	}

	@Override
	public long count() {
		return hashOps.keys(RESERVATIONS_KEY).size();
	}

	@Override
	public void delete(String id) {
		hashOps.delete(RESERVATIONS_KEY, id);
	}

	@Override
	public void delete(Reservation Reservation) {
		hashOps.delete(RESERVATIONS_KEY, Reservation.getId());
	}

	@Override
	public void delete(Iterable<? extends Reservation> Reservations) {
		for (Reservation Reservation : Reservations) {
			delete(Reservation);
		}
	}

	@Override
	public void deleteAll() {
		Set<String> ids = hashOps.keys(RESERVATIONS_KEY);
		for (String id : ids) {
			delete(id);
		}
	}

	private <T> List<T> convertIterableToList(Iterable<T> iterable) {
		List<T> list = new ArrayList<T>();
		for (T object : iterable) {
			list.add(object);
		}
		return list;
	}


}
