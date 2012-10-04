package za.co.invoketech.store.application.util.library;

import static java.lang.System.getProperty;
import static java.util.regex.Pattern.CASE_INSENSITIVE;

import java.util.regex.Pattern;

public class Platform {

	public enum Arch {
        x86   ("x86|i386"),
        x86_64("x86_64|amd64");

        Pattern pattern;

        Arch(String pattern) {
            this.pattern = Pattern.compile("\\A" + pattern + "\\Z", CASE_INSENSITIVE);
        }
    }

    public enum OS {
        darwin ("darwin|mac os x"),
        freebsd("freebsd"),
        linux  ("linux");

        Pattern pattern;

        OS(String pattern) {
            this.pattern = Pattern.compile("\\A" + pattern + "\\Z", CASE_INSENSITIVE);
        }
    }

    public final Arch arch;
    public final OS os;

    private Platform(Arch arch, OS os) {
        this.arch = arch;
        this.os = os;
    }
    
    public static Platform detect() throws UnsupportedPlatformException {
        String osArch = getProperty("os.arch");
        String osName = getProperty("os.name");

        for (Arch arch : Arch.values()) {
            if (arch.pattern.matcher(osArch).matches()) {
                for (OS os : OS.values()) {
                    if (os.pattern.matcher(osName).matches()) {
                        return new Platform(arch, os);
                    }
                }
            }
        }

        String msg = String.format("Unsupported platform %s %s", osArch, osName);
        throw new UnsupportedPlatformException(msg);
    }
}
