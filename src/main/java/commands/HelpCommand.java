package commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import net.dv8tion.jda.core.EmbedBuilder;
import java.awt.*;

public class HelpCommand extends Command {

    public HelpCommand(){
        this.name = "mdr";
        this.aliases = new String[]{"svp"};
        this.help = "Gives information about the server.";
    }

    @Override
    protected void execute(CommandEvent event) {
        String[] test = new String[event.getGuild().getMembers().size()];
        for(int i = 0; i < event.getGuild().getMembers().size();i++){
            test[i] = event.getGuild().getMembers().get(i).getEffectiveName();
        }

        EmbedBuilder eb = new EmbedBuilder();
        eb.setColor(Color.RED);
        eb.setTitle("Help");
        eb.setThumbnail("http://prntscr.com/pgy4zf");
        eb.addField("Server Owner:", event.getGuild().getOwner().getEffectiveName(), true);
        eb.setDescription("**» ! user ** \ninformation of user" + "" + "\n **» ! serverinfo** \n" + "server information" + "\n**» ! ticket**\n" + "create a ticket\n" + "**» ! announce**" );

        event.getChannel().sendMessage(eb.build()).queue();
    }
}
