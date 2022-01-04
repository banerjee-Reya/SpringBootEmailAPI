
# Sending email using Spring Boot
1. To send email, declares spring-boot-starter-mail, it will pull the JavaMail dependencies.
2. This example is using Gmail SMTP server, tested with TLS (port 587) and SSL (port 465).

          # Other properties
          spring.mail.properties.mail.smtp.auth=true
          spring.mail.properties.mail.smtp.connectiontimeout=5000
          spring.mail.properties.mail.smtp.timeout=5000
          spring.mail.properties.mail.smtp.writetimeout=5000

          # TLS , port 587
          spring.mail.properties.mail.smtp.starttls.enable=true
 
 3. Spring provides an JavaMailSender interface on top of JavaMail APIs.
 
    3.1) Send a normal text email.
          
                import org.springframework.mail.SimpleMailMessage;
                import org.springframework.mail.javamail.JavaMailSender;

                    @Autowired
                      private JavaMailSender javaMailSender;

                    void sendEmail() {

                          SimpleMailMessage msg = new SimpleMailMessage();
                          msg.setTo("to_1@gmail.com", "to_2@gmail.com", "to_3@yahoo.com");

                          msg.setSubject("Testing from Spring Boot");
                          msg.setText("Hello World \n Spring Boot Email");

                          javaMailSender.send(msg);

                      }
                      
                      
          
    3.2) Send an HTML email and a file attachment.
          
          
                    import org.springframework.core.io.ClassPathResource;
                    import org.springframework.mail.javamail.JavaMailSender;
                    import org.springframework.mail.javamail.MimeMessageHelper;

                    import javax.mail.MessagingException;
                    import javax.mail.internet.MimeMessage;

                      void sendEmailWithAttachment() throws MessagingException, IOException {

                            MimeMessage msg = javaMailSender.createMimeMessage();

                            // true = multipart message
                            MimeMessageHelper helper = new MimeMessageHelper(msg, true);

                            helper.setTo("to_@email");

                            helper.setSubject("Testing from Spring Boot");

                            // default = text/plain
                            //helper.setText("Check attachment for image!");

                            // true = text/html
                            helper.setText("<h1>Check attachment for image!</h1>", true);

                        // hard coded a file path
                            //FileSystemResource file = new FileSystemResource(new File("path/android.png"));

                            helper.addAttachment("my_photo.png", new ClassPathResource("android.png"));

                            javaMailSender.send(msg);

                        }
          
# Explore and try the api using the url
http://localhost:8080/contact
