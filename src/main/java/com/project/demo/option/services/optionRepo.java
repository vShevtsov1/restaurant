package com.project.demo.option.services;

import com.project.demo.option.data.Option;
import org.springframework.data.repository.CrudRepository;

public interface optionRepo extends CrudRepository<Option,Long> {
}
