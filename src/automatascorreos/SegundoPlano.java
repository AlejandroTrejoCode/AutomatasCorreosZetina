

//AUTOR: SERGIO ALEJANDRO TREJO CUXIM
//MATERIA: LENGUAJES Y AUTOMATAS
//LICENCIA MIT

package automatascorreos;

import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import java.util.Properties;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Part;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.Timer;

public class SegundoPlano extends javax.swing.JFrame {   
    
    //PROPIEDADES
    private ImageIcon Image;
    private TrayIcon Icon;
    private SystemTray Tray;
    
    public SegundoPlano() {
        
        //CARGAR EL ICONO
        Image = new ImageIcon(this.getClass().getResource("/images/icon.png"));
        initComponents();                
        this.setIconImage(Image.getImage());
        
        //INICIA EL SERVICIO EN SEGUNDO PLANO
        StartService();
    }
    
    //INSTANCIA DEL SERVICIO
    //MOSTRARÁ EN LA BARRA DE HERRAMIENTAS
    public void StartService () {
        Icon = new TrayIcon(Image.getImage(), "MailScript", popupMenu1);
        Icon.setImageAutoSize(true);
        Tray = SystemTray.getSystemTray();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popupMenu1 = new java.awt.PopupMenu();
        menuItem1 = new java.awt.MenuItem();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();

        popupMenu1.setLabel("popupMenu1");

        menuItem1.setActionCommand("Abrir");
        menuItem1.setLabel("Salir");
        menuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItem1ActionPerformed(evt);
            }
        });
        popupMenu1.add(menuItem1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MailScript");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Open Sans Semibold", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("MailScript");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 300, 50));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setBackground(new java.awt.Color(0, 102, 102));
        jButton1.setFont(new java.awt.Font("Open Sans Semibold", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("RUN MAIL SERVICE");
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 55, 180, 40));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 300, 150));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    //INICIAR SERVICIO AL PRESIONAR INICIAR
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        ServicioAutomata Service = new ServicioAutomata();
        
        try {
            
            if (SystemTray.isSupported()) {
                Tray.add(Icon);
                this.setVisible(false);
                
                //INICIA EL TEMPORIZADOR
                RefreshTime.start();
            }                        
                        
        } catch (Exception e) {
            
            //SI EXISTE UN PROBLEMA MUESTRA EL ERROR
            JOptionPane.showMessageDialog(null, "Ocurrió un error " + e);
            
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    //TEMPORIZADOR, CADA 10 SEGUNDOS VERIFICARÁ LOS CORREOS
    Timer RefreshTime = new Timer (10000, new ActionListener () 
    { 
        public void actionPerformed(ActionEvent e) 
        { 
            //INICIA EL SERVICIO AUTOMATA
            ServicioAutomata ServiceObject = new ServicioAutomata();
            
        }
    }); 
    
    private void menuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItem1ActionPerformed
        
        //CUANDO CLICKEAS EN ABRIR
        Tray.remove(Icon);
        this.setVisible(true);
        
    }//GEN-LAST:event_menuItem1ActionPerformed

    
    public static void main(String args[]) {
        
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SegundoPlano.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SegundoPlano.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SegundoPlano.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SegundoPlano.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SegundoPlano().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private java.awt.MenuItem menuItem1;
    private java.awt.PopupMenu popupMenu1;
    // End of variables declaration//GEN-END:variables

}


//CLASE DEL SERVICIO A CONSUMIR

class ServicioAutomata {
    
    //VARIABLES
    public static String Sujeto = "";
    public static int Cantidad;
    public static String Reenviar = "";
    
    public ServicioAutomata () {
        
        //SI ES GMAIL NO SE TOCA
        Properties prop = new Properties();
        prop.setProperty("mail.pop3.starttls.enable", "false");
        prop.setProperty("mail.pop3.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        prop.setProperty("mail.pop3.socketFactory.fallback", "false");
        prop.setProperty("mail.pop3.port", "995");
        prop.setProperty("mail.pop3.socketFactory.port", "995");
        Session sesion = Session.getInstance(prop);    
        
        try
        {
          // Se obtiene el Store y el Folder, para poder leer el correo.
          // SOLO SE LEERÁN LOS CORREO "CRECIBIDOS" SI ES LA PRIMERA VEZ, TAL VEZ CARGUEN TODOS LOS QUE EXISTAN            
            Store store = sesion.getStore("pop3");
            //La bandeja
            store.connect("pop.gmail.com", "201500132@estudiantes.upqroo.edu.mx", "sergiocode1");
            Folder folder = store.getFolder("INBOX");
            folder.open(Folder.READ_ONLY);

            // Se obtienen los mensajes recibidos.
            Message[] mensajes = folder.getMessages();

            // Se escribe Sujecto y el Asunto de cada mensaje
            for (int i = 0; i < mensajes.length; i++)                
            {
                System.out.println("---------------------------------");
                System.out.println("De: " + mensajes[i].getFrom()[0].toString());
                Sujeto = mensajes[i].getFrom()[0].toString();
                System.out.println("Asunto:" + mensajes[i].getSubject());
                
                // Se visualiza, si se sabe como, el contenido de cada mensaje
                AnalizarMensaje(mensajes[i]);
            }            

            folder.close(false);
            store.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        } 
        
    }
    
        
    /**
     * Metodo recursivo.
     * Si la parte que se pasa es compuesta, se extrae cada una de las subpartes y el metodo se llama a si mismo con cada una de ellas.
     * Si la parte es un text, se escribe en pantalla.     
     * En cualquier otro caso, simplemente se escribe el tipo recibido, pero se ignora el mensaje.     
     */
    
    private static void AnalizarMensaje(Part unaParte) {
        try {
            
            // Si es multipart, se analiza cada una de sus partes recursivamente.
            if (unaParte.isMimeType("multipart/*"))
                
            {
                Multipart multi;
                multi = (Multipart) unaParte.getContent();

                for (int j = 0; j < multi.getCount(); j++)
                {
                    AnalizarMensaje(multi.getBodyPart(j));
                }
            }
            else {
                // Si es texto, se escribe el texto.
                if (unaParte.isMimeType("text/plain"))
                {
                    //System.out.println("Texto " + unaParte.getContentType()); 
                    String Contexto = (String) unaParte.getContent();
                    System.out.println(unaParte.getContent());                    
                    System.out.println("---------------------------------");
                    Contexto(Contexto);
                    ExtrarNumero(Contexto);
                }
            }            
        } catch (Exception e) {
            
        }
    }
    
        public static void Contexto (String Context) {
        System.out.println("Mensaje capturado en formato plano: " +Context);
        System.out.println("El sujeto fue: " +Sujeto);
        
        if( (Context.contains("comprar")) || (Context.contains("adquirir")) || (Context.contains("vendan")) || (Context.contains("aquisición")) || (Context.contains("compra")) ) {
            
            System.out.println("Contiene una venta"); 
            RespuestaAutomatica(Sujeto);
            ExtrarNumero(Context);
        }
        else {
            System.out.println("Sepa que quiere");
            RespuestaAutomatica(Sujeto);
        }        
    }
        
     //Responder que ya se está atendiendo (Respuesta automática)
    //CAMBIAR USER AND PASSWORD, ESTE ENVIARÁ EL CORREO
    public static void RespuestaAutomatica (String Destinatario) {
        
        //La misma que la bandeja
        final String username = "201500132@estudiantes.upqroo.edu.mx";
	final String password = "sergiocode1";
        
        
        Properties props = new Properties();
	props.put("mail.smtp.auth", "true");
	props.put("mail.smtp.starttls.enable", "true");	                
        props.put("mail.smtp.host", "smtp.gmail.com");
	props.put("mail.smtp.port", "587");
        
        
        Session session = Session.getInstance(props,
        new javax.mail.Authenticator() {
	
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
        
                
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("****@gmail.com"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(Destinatario));
            message.setSubject("Respuesta Automática de Compra en Trejo Shop");
            message.setText("Gracias por su interés, estamos procesado su solicitud");
            Transport.send(message);
            System.out.println("Respuesta Automática enviada");            
	} catch (MessagingException e) {
            System.out.println("No se envío error: " + e  + " La respuesta correcta");
            throw new RuntimeException(e);               
        }
    }
    
    //MÉTODO VERIFICA LA CANTIDAD A AQUIRIR, SI ES UNA COMPRA GRANDE SE ENVIA AL GERENTE, SI NO, AL VENDEDOR
    public static void ExtrarNumero (String Cadena) {
        String Numero = "";
        for(int i = 0; i < Cadena.length(); i++){
            if(Character.isDigit(Cadena.charAt(i))){
                Numero = Numero + Cadena.charAt(i);
            }
        }
        System.out.println("La cantidad es de: " + Numero);
        Cantidad = Integer.parseInt(Numero);                
        
        
        //ENVIO LA CANTIDAD Y EL CORREO
        if (Cantidad > 1000) {
            //Enviar al Jefe
            Reenviar = "alejandrotrejocodefeed@gmail.com";
            Despachar(Reenviar, Cadena);
        }
        else {
            //Enviar al Vendedor
            Reenviar = "alejandrotrejocodevideos@gmail.com";
            Despachar(Reenviar, Cadena);
        }        
    }
    
 
    
    //REPARTIR AL ENCARGADO, YA SEA EL GERENTE O EL VENDEDOR   
    
    public static void Despachar (String Destino, String Mensaje) {
        //La misma que la bandeja
        final String username = "201500132@estudiantes.upqroo.edu.mx";
	final String password = "sergiocode1";
        
        
        Properties props = new Properties();
	props.put("mail.smtp.auth", "true");
	props.put("mail.smtp.starttls.enable", "true");	                
        props.put("mail.smtp.host", "smtp.gmail.com");
	props.put("mail.smtp.port", "587");
        
        
        Session session = Session.getInstance(props,
        new javax.mail.Authenticator() {
	
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
        
                
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("****@gmail.com"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(Destino));
            message.setSubject("Nueva venta");
            message.setText("Correo de: " +Sujeto + ", Mensaje: " + Mensaje);
            Transport.send(message);
            System.out.println("Enviado");            
	} catch (MessagingException e) {
            System.out.println("No se envío" + e);
            throw new RuntimeException(e);               
        }
    }
         
}