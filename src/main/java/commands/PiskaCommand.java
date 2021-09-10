package commands;

import org.telegram.telegrambots.extensions.bots.commandbot.commands.DefaultBotCommand;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.bots.AbsSender;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.Random;

import static java.lang.String.format;

public class PiskaCommand extends DefaultBotCommand {

    public PiskaCommand(String commandIdentifier, String description) {
        super(commandIdentifier, description);
    }

    @Override
    public void execute(AbsSender absSender, User user, Chat chat, Integer messageId, String[] arguments) {
        SendMessage message = new SendMessage();
        String username = user.getUserName();
        String id = user.getId().toString();

        message.enableMarkdownV2(true);
        message.setChatId(chat.getId().toString());
        message.setText(format("[%s](tg://user?id=%s) %s", username, id, generateText(generateRandomSize())));
        try {
            absSender.execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    private int generateRandomSize() {
        return new Random().ints(-10, 10).findFirst().getAsInt();
    }

    private String generateText(int size) {
        String answer;

        if (size > 0) {
            answer = String.format("your biba grew up\\! \\+%s cm", size);
        } else if (size < 0) {
            answer = String.format("your biba shrunk\\! \\%s cm", size);
        } else {
            answer = "your remained the same";
        }

        return answer;
    }

}
