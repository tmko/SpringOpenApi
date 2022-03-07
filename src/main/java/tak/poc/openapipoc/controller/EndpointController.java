package tak.poc.openapipoc.controller;


import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

@RestController
public class EndpointController implements EndpointControllerInterface {


    @Override
    public List<InfoItem> queryFakeInfo(Authentication authentication, int count) {
        String smUserId = String.format("Auth=%s",authentication.getCredentials().toString());

        return IntStream
                .range(0,count)
                .mapToObj(InfoItem::new)
                .map(x -> x.appendTo(smUserId))
                .collect(toList());
    }

    @Override
    public void updateInfo(Authentication authentication, int id, InfoItem input) {
        if (id > 100) throw new InfoItem.InfoItemNotFound();
    }
}