import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class Main {
    public static void main(String[] args) {
        try {
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
            botsApi.registerBot(new Bot("Piskin", "1987216233:AAHeZFBa_Hk3e40lNZROBcwcRT5RYmvO2hQ"));
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
