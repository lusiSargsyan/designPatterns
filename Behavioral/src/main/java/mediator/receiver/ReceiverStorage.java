package mediator.receiver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ReceiverStorage implements Storage<Receiver> {

    private List<Receiver> receivers;

    public ReceiverStorage() {
        this.receivers = new ArrayList<>();
    }

    @Override
    public Receiver get(int index) {
        return receivers.get(index);
    }

    @Override
    public Receiver get(String email) {
        Optional<Receiver> receiver = receivers.stream()
                .filter(r -> email.equals(r.getEmail()))
                .findFirst();
        return receiver.orElse(null);
    }

    @Override
    public void add(Receiver receiver) {
        receivers.add(receiver);
    }

    @Override
    public void addAll(Receiver... elements) {
      receivers.addAll(Arrays.asList(elements));
    }
}
