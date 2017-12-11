package online.exam.datacenter.jerseyservice;

import com.google.gson.Gson;
import io.swagger.annotations.*;
import online.exam.datacenter.VO.ExamResponse;
import online.exam.datacenter.model.Exam;
import online.exam.datacenter.model.Student;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        Map<String, Object> response = new HashMap<String, Object>();
        try {
            FormDataBodyPart filePart = form.getField("file");
            List<Student> studentList = onlineExamService.importFile(filePart.getValueAs(InputStream.class));
            response.put("status", "success");
            response.put("participants", studentList);
            return Response.status(Response.Status.OK).entity(response).build();
        } catch (IOException e) {
            e.printStackTrace();
            response.put("status", "fail");
            response.put("errMsg", e.getMessage());
            return Response.status(Response.Status.OK).entity(response).build();
        }
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

        Map<String, Object> response = new HashMap();
        response.put("status", "success");
        response.put("path", "sadasdsdas");
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
            @ApiParam Exam examInfo) {

        return null;
    }

    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(
            value = "老师新生成考试")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = EndpointResponse.class),
            @ApiResponse(code = 404, message = "NOT FOUND")
    })
    public Response createExam(@ApiParam Exam exam) {
        ExamResponse response = onlineExamService.createExam(exam);
        return Response.status(Response.Status.OK).entity(new Gson().toJson(response)).build();
    }
}
