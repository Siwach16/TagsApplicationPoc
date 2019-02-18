/**
 * Created by tat50037 on 16/12/18.
 */
package com.myproject.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;
import lombok.ToString;
import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Reference;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity(value = "Tags", noClassnameStored = true)
public class Tag {
    @NotNull
    @Id
    @JsonSerialize(using = ToStringSerializer.class)
    private ObjectId tagId;
    @NotNull
    private String tagName;
    @Reference
    private Tag parentTag;

}
