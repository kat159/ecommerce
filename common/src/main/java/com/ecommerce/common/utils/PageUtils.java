

package com.ecommerce.common.utils;

import com.ecommerce.common.dto.PaginationDto;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 分页工具类
 */
public class PageUtils implements Serializable {
	static public List<Order> getOrders(PaginationDto paginationDto) {
		List<Order> orders = new ArrayList<>();
		List<String> orderFields = paginationDto.getOrderFields();
		List<String> orderTypes = paginationDto.getOrderTypes();

		for (int i = 0; i < orderFields.size(); i++) {
			String field = orderFields.get(i);
			Sort.Direction direction = Sort.Direction.ASC;
			if (orderTypes.size() > i && orderTypes.get(i).equalsIgnoreCase("desc")) {
				direction = Sort.Direction.DESC;
			}
			orders.add(new Order(direction, field));
		}

		if (orders.isEmpty()) {
			orders.add(new Order(Sort.Direction.ASC, "id"));
		}

		return orders;
	}
}
