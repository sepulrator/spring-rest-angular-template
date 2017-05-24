package org.spring.template.core.helper;

import org.spring.template.core.constants.CacheConstants;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Component;

/**
 * Created by osman on 13.5.2017.
 */
@Component
public class CacheEvictHelper {

    @CacheEvict(cacheNames = CacheConstants.PERSON_LIST ,allEntries = true)
    public void evictPersonListCache() {

    }

}
