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
import java.util.Set;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/")
@Setter
public class TagsResource {

    @Inject
    private TagsService tagsService;

    @GET
    @Path("/getTag/name/")
    public Tag getTagByName(@QueryParam("name") String name){
        return tagsService.getTagByName(name);
    }

    @GET
    @Path("/getTag/id/{id}")
    public Tag getTagById(@PathParam("id") String id){
        return tagsService.getTagById(id);
    }


    @GET
    @Path("/getAllTags")
    public List<Tag> getAllTags(){
        return tagsService.getAllTags();
    }
    @GET
    @Path("/getAllParentTags")
    public Set<Tag> getAllParentTags(@QueryParam("id") List<String> ids){
        return tagsService.getAllParentTags(ids);
    }

    @GET
    @Path("/getAllTagsById")
    public List<Tag> getAllTags(@QueryParam("id") List<String> ids){
        return tagsService.getAllTags(ids);
    }

    @POST
    @Path("/addTag")
    public String addTags(Tag tag){
        return tagsService.addTag(tag);

    }
}
