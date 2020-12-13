package ipk.controller;

import ipk.service.ListenerService;
import org.springframework.stereotype.Controller;

@Controller
public class ListenerController {
    private final ListenerService listenerService;

    public ListenerController(ListenerService listenerService) {
        this.listenerService = listenerService;
    }
}
