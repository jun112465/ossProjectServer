package jun.ossProject.getTeam.controller;

import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class testController {


    @GetMapping("/test")
    @ResponseBody
    public TestVO testRestApi() {
        return new TestVO("1", "Star Wars", "1977");
    }

    @Data
    class TestVO{
        public TestVO(String id, String title, String releaseYear) {
            this.title = title;
            this.id = id;
            this.releaseYear = releaseYear;
        }

        String title;
        String id;
        String releaseYear;
    }


}
