package online.exam.datacenter.service;

import java.io.IOException;
import java.io.InputStream;

public interface OnlineExamService {

    void importFile(InputStream valueAs) throws IOException;
}
