import implementation.Mentor;
import service.FullTimeMentor;
import service.MentorAccount;
import service.PartTimeMentor;

public class CompanyApp {

    public static void main(String[] args) {
        FullTimeMentor fullTime = new FullTimeMentor();
        MentorAccount mentor1 = new MentorAccount(fullTime);
        mentor1.manageAccount();

        PartTimeMentor partTime = new PartTimeMentor();
        MentorAccount mentor2 = new MentorAccount(partTime);
        mentor2.manageAccount();
    }
}
