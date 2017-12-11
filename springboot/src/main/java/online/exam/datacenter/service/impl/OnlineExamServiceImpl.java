package online.exam.datacenter.service.impl;

import online.exam.datacenter.service.OnlineExamService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;


@Service
public class OnlineExamServiceImpl implements OnlineExamService {

    @Override
    public void importFile(InputStream valueAs) throws IOException {
        System.out.println("importFile");
    }
}
