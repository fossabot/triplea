package games.strategy.engine.pbem;

import games.strategy.engine.framework.startup.ui.editors.EditorPanel;
import games.strategy.engine.framework.startup.ui.editors.EmailSenderEditor;
import games.strategy.triplea.help.HelpSupport;

public class GmailEmailSender extends GenericEmailSender {
  private static final long serialVersionUID = 3511375113962472063L;

  /**
   * Initializes a new instance of the {@code GmailEmailSender} class.
   */
  public GmailEmailSender() {
    setHost("smtp.gmail.com");
    setPort(587);
    setEncryption(Encryption.TLS);
  }

  @Override
  public EditorPanel getEditor() {
    return new EmailSenderEditor(this, new EmailSenderEditor.EditorConfiguration());
  }

  @Override
  public String getDisplayName() {
    return "Gmail";
  }

  @Override
  public IEmailSender clone() {
    final GenericEmailSender sender = new GmailEmailSender();
    sender.setSubjectPrefix(getSubjectPrefix());
    sender.setPassword(getPassword());
    sender.setToAddress(getToAddress());
    sender.setUserName(getUserName());
    sender.setAlsoPostAfterCombatMove(getAlsoPostAfterCombatMove());
    sender.setCredentialsSaved(areCredentialsSaved());
    return sender;
  }

  @Override
  public String getHelpText() {
    return HelpSupport.loadHelp("gmailEmailSender.html");
  }
}
