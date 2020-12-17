package cbandi;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.KinesisFirehoseEvent;

import java.nio.charset.StandardCharsets;
import java.util.List;

import static java.util.Collections.emptyList;
import static java.util.stream.Collectors.toList;

public class FirehoseEventHandler implements RequestHandler<KinesisFirehoseEvent, List<String>> {

    @Override
    public List<String> handleRequest(KinesisFirehoseEvent input, Context context) {
        System.out.println("Running test lambda");
        if(input.getRecords() == null || input.getRecords().isEmpty()) {
            System.out.println("Got an null/empty list");
            return emptyList();
        }

        return input.getRecords()
                .stream()
                .map(record -> {
                    String data = new String(record.getData().array(), StandardCharsets.UTF_8);
                    System.out.println(data);
                    return record.getData().toString();
                })
                .collect(toList());
    }
}

//cbandi.FirehoseEventHandler::handleRequest