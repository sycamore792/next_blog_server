package com.sycamore.nextblog.client.user.dto.resp;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.util.StringUtils;

/**
 * @author: Sycamore
 * @date: 2024/7/16 18:26
 * @version: 1.0
 * @description: TODO
 */
@Data
@AllArgsConstructor
public class UserSessionMetadataQueryCO {
    private String userId;
    private String userName;


    public boolean isValid() {
        return this.userId != null && this.userName != null;
    }
}
