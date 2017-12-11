package online.exam.datacenter.jerseyservice;

import com.google.gson.Gson;
import io.swagger.annotations.*;
import io.swagger.util.Json;
import online.exam.datacenter.model.ExamCreation;
import online.exam.datacenter.model.TestInfo;
import online.exam.datacenter.service.OnlineExamService;
import org.glassfish.jersey.media.multipart.FormDataBodyPart;
import org.glassfish.jersey.media.multipart.FormDataMultiPart;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.io.InputStream;

@Component
@Path("/onlineexam")

@Produces(MediaType.APPLICATION_JSON)
@Api(value = "Online Exam API", produces = "application/json")
public class OnlineExamEndpoint {
    private static final Logger LOGGER = LoggerFactory.getLogger(OnlineExamEndpoint.class);

    @Autowired
    OnlineExamService onlineExamService;

    @POST
    @Path("/loadStudentList")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @ApiOperation(
            value = "上传考试学生名单")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = EndpointResponse.class),
            @ApiResponse(code = 404, message = "NOT FOUND")
    })
    public Response loadStudentList(@ApiParam FormDataMultiPart form) {
        LOGGER.info("begin to upload student list!!");
        try {
            FormDataBodyPart filePart = form.getField("file");
            onlineExamService.importFile(filePart.getValueAs(InputStream.class));
        } catch (IOException e) {
            e.printStackTrace();
            EndpointResponse response = new EndpointResponse("fail");
            response.putDate("errMsg", e.getMessage());
            return Response.status(Response.Status.OK).entity(response).build();
        }
        EndpointResponse response = new EndpointResponse("success");
        return Response.status(Response.Status.OK).entity(response).build();
    }


    @GET
    @Path("/exam/{examID}")
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(
            value = "查看某一考试基本信息（无试题）"
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = TestInfo.class),
            @ApiResponse(code = 404, message = "NOT FOUND")
    })
    public Response checkExam(@ApiParam @PathParam("examID") String examID) {

        EndpointResponse response = new EndpointResponse("success");
        response.putDate("path","sadasdsdas");
        return Response.status(Response.Status.OK).entity(new Gson().toJson(response)).build();
    }


    @POST
    @Path("/start")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @ApiOperation(value = "考生开始考试")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = EndpointResponse.class),
            @ApiResponse(code = 404, message = "NOT FOUND")
    })
    public Response startExam(
            @ApiParam ExamCreation examInfo) {

        return null;
    }

    @POST
    @Path("/create")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @ApiOperation(
            value = "老师新生成考试")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = EndpointResponse.class),
            @ApiResponse(code = 404, message = "NOT FOUND")
    })
    public Response createExam(@ApiParam ExamCreation examInfo) {

        return null;
    }
}
