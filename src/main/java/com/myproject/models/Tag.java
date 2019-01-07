/**
 * Created by tat50037 on 16/12/18.
 */
package com.myproject.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.ToString;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity(value = "Tags", noClassnameStored = true)
public class Tag {
    @NotNull
    @Id
    private String tagName;
    private String parentTag;

}
