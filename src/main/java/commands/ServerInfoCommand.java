package commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import net.dv8tion.jda.core.EmbedBuilder;
 
import java.awt.*;
import java.util.Arrays;
 
public class ServerInfoCommand extends Command {
 
    public ServerInfoCommand(){
        this.name = "serverinfo";
        this.aliases = new String[]{"server"};
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
        eb.setAuthor(event.getGuild().getName());
        eb.setThumbnail("https://static.thenounproject.com/png/937475-200.png");
        eb.addField("Server Owner:", event.getGuild().getOwner().getEffectiveName(), true);
        eb.addField("Member Count:", Integer.toString(event.getGuild().getMembers().toArray().length), true);
        eb.setDescription("**Members:** \n" + Arrays.toString(test) + "\n **Invite link:** \n" + "https://discord.gg/3stGDun");

        event.getChannel().sendMessage(eb.build()).queue();
        event.getChannel().sendMessage(event.getAuthor().getAsMention()).queue();
    }
}