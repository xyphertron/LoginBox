import javax.swing.*;
import java.awt.event.*;
import java.util.Random; 

class Captcha
{
	String GenerateCaptcha()
	{
		Random num = new Random();
		int i,j,k,l,m,n,o;
		i = num.nextInt(10);
		j = num.nextInt(26);
		k = num.nextInt(26);
		l = num.nextInt(10);
		m = num.nextInt(10);
		n = num.nextInt(26);
		o = num.nextInt(26);

		String arrS[]={"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
		String arrB[]={"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
		String arr[]={"0","1","2","3","4","5","6","7","8","9"};

		return arr[i]+arrB[j]+arrS[k]+arr[l]+arrS[o]+arr[m]+arrB[n];		
	}
}

public class LoginBox{   
    public static void main(String[] args) {             

        //creation of frame and panel
        JPanel panel = new JPanel();
        JFrame frame = new JFrame("Student's Login");
        frame.setSize(400,350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);

        panel.setLayout(null);

        //user id text label
        JLabel label = new JLabel("USER ID");
        label.setBounds(10, 20, 80, 25);
        panel.add(label);

        //text box to enter used id
        JTextField userText = new JTextField();
        userText.setBounds(100,20,165,25);
        panel.add(userText);

        //password text label
        JLabel pswdlabel = new JLabel("PASSWORD");
        pswdlabel.setBounds(10, 50, 80, 25);
        panel.add(pswdlabel);

        //text box to enter password
        JPasswordField password = new JPasswordField();
        password.setBounds(100,50,165,25);
        panel.add(password);

        //captcha text label
        JLabel captcha = new JLabel("CAPTCHA");
        captcha.setBounds(10, 80, 80, 25);
        panel.add(captcha);
       
        Captcha show = new Captcha();
		String captchaText = show.GenerateCaptcha();

        //label to display captcha
        JLabel captchaDisplay = new JLabel(captchaText);
        captchaDisplay.setBounds(150, 80, 80, 25);
        panel.add(captchaDisplay);

        //enter captcha text label
        JLabel userCaptcha = new JLabel("Enter Captcha");
        userCaptcha.setBounds(10, 110, 100, 25);
        panel.add(userCaptcha);

        //text box to enter captcha
        JTextField Captcha = new JTextField();
        Captcha.setBounds(148,110,85,25);
        panel.add(Captcha);

        String arrUserId[] = {"One","Two","Three"};
        String arrPassword[] = {"1234","1234","1234"};

        JLabel message = new JLabel();
        message.setBounds(148,200,240,35);
        panel.add(message);

        JButton button = new JButton("Login");
        button.setBounds(148,150,80,35);
        button.addActionListener(new ActionListener()
        {  
            public void actionPerformed(ActionEvent e)
            {  
                String userId = userText.getText();
                String userPassword = password.getText();
                String enteredCaptcha = Captcha.getText();

                for(int i=0;i<arrUserId.length;i++)
                {
                    if(userId.equals(arrUserId[i]) && userPassword.equals(arrPassword[i]) && enteredCaptcha.equals(captchaText))
                    {
                        message.setText("Login Successful");
                    }
                    else if (!userId.equals(arrUserId[i]) && !userPassword.equals(arrPassword[i]) && enteredCaptcha.equals(captchaText))
                    {
                        message.setText("Incorrect Id or password. Try again!!");                       
                    }
                    else if (userId.equals(arrUserId[i]) && userPassword.equals(arrPassword[i]) && !enteredCaptcha.equals(captchaText))
                    {
                        message.setText("Captcha Error");
                    }
                    else if (!userId.equals(arrUserId[i]) && !userPassword.equals(arrPassword[i]) && !enteredCaptcha.equals(captchaText))
                    {
                        message.setText("Try Again");
                    }
                }               
            }  
        });  
        panel.add(button);
        frame.setVisible(true);
    }    
}