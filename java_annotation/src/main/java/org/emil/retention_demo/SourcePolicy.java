package org.emil.retention_demo;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @Author: emil
 * @Date: 2023/5/11 9:40
 * @Version: v1.0.0
 * @Description: TODO
 **/
@Retention(RetentionPolicy.SOURCE)
public @interface SourcePolicy {
}
