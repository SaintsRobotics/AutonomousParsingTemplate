/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.ManyParameterCommand;
import frc.robot.commands.OneParameterCommand;
import frc.robot.commands.ZeroParameterCommand;

/**
 * Change the if else statements at the bottom of the file. Each command you
 * want the parser to be able to use needs an identifier. The identifier needs
 * to be unique to each command, and is what goes in the if check. Follow the
 * examples below.
 * 
 * Do NOT add any static variables to this class, or any initialization at all.
 * Unless you know what you are doing, do not modify this file except to change
 * the parameter class to the startRobot call.
 */
public class KeyParser {
    private static SequentialCommandGroup group;
    private static String[] keyArray;

    /**
     * This function separates a string input from the user into a sequence of
     * commands.
     * 
     * @param rawInput the input from the user to be parsed
     * @return the sequence of commands to be run in autonomous
     * 
     */
    public static SequentialCommandGroup parse(String rawInput) {
        keyArray = rawInput.split("; "); // keys will be separated by a semicolon followed by a space
        group = new SequentialCommandGroup();

        for (String key : keyArray) {

            String[] arr = key.split("@"); // keys will be formatted: ID@params
            String ID = arr[0];
            String params = "";
            if (arr.length > 1) {
                params = arr[1];
            }

            /**
             * Add the if-else statements here. This is the main section of code that should
             * be changed. You should check if the ID is equal to the unique identifier you
             * have chosen to map to each command. Any and all specific parameters the
             * command needs should be passed in via the params variable. The identifiers
             * can be stored in Constants.java or here if so desired. The subsystem for each command should be fed in via the subsystem map.
             *
             * LINES UNDER MUST BE CHANGED FOR THIS TO WORK.
             * THIS IS AN EXAMPLE OF THE FORMATTING.
             * REPLACE THE COMMANDS WITH YOUR DESIRED COMMANDS AND THE IDS WITH YOUR DESIRED IDS.
             * DO NOT CONSTRUCT NEW SUBSYSTEMS HERE; FEED THEM IN FROM SUBSYSTEMMAP.JAVA 
             */

            if (ID.equals("zero")) {
                group.addCommands(new ZeroParameterCommand(params, SubsystemMap.exampleSubsystem));
            } else if (ID.equals("one")) {
                group.addCommands(new OneParameterCommand(params, SubsystemMap.exampleSubsystem));
            } else if (ID.equals("many")) {
                group.addCommands(new ManyParameterCommand(params, SubsystemMap.exampleSubsystem));
            }

        }
        return group;
    }
}
