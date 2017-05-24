package org.spring.template.service.common;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by osman on 9.5.2017.
 */
public interface ICrudService<T,K> {

    public T create(T item);
    public T read(K id);
    public T update(T item);
    public void delete(K id);
    public List<T> list();
    public Page<T> listByPage(Pageable pageable);

}
