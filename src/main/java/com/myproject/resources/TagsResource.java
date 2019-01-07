/**
 * Created by tat50037 on 16/12/18.
 */
package com.myproject.resources;


import com.myproject.models.Tag;
import com.myproject.service.TagsService;
import lombok.Setter;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/")
@Setter
public class TagsResource {

    @Inject
    private TagsService tagsService;

    @GET
    @Path("/getTag/{name}")
    public Tag getTags(@PathParam("name") String name){
        return tagsService.getTag(name);
    }

    @GET
    @Path("/getAllTags")
    public List<Tag> getAllTags(){
        return tagsService.getAllTags();
    }

    @POST
    @Path("/addTag")
    public String addTags(Tag tag){
        return tagsService.addTag(tag);

    }
}
