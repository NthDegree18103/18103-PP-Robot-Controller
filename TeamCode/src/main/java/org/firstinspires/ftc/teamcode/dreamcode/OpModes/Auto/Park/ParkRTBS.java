package org.firstinspires.ftc.teamcode.dreamcode.OpModes.Auto.Park;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.dreamcode.OpModes.Auto.AutoTemplate;
import org.firstinspires.ftc.teamcode.dreamcode.States.DriveMode;

@Autonomous(group = "Park")
        public class ParkRTBS extends AutoTemplate {
            double a = 0;
            @Override
            public void buildPath() {
                setStartA(a);
                path.add(() -> setSpeed(DriveMode.Economy));
                path.add(() -> tilePointDrive(0, -0.1, a));
                path.add(() -> closeClaw());
                path.add(() -> pause(1));
                path.add(() -> setSpeed(DriveMode.Sport));
                path.add(() -> tilePointDriveUnscaled(0, -1, a));
                path.add(() -> tilePointDriveUnscaled(1.3, -1, a));
                path.add(this :: setLiftMid);
                path.add(() -> setSpeed(DriveMode.Economy));
                path.add(() -> pause(2));
                path.add(() -> tilePointDrive(1.3, -0.9, a));
                path.add(() -> pause(2));
                path.add(this ::lowerLift);
                path.add(() -> pause(2));
                path.add(() -> openClaw());
                path.add(() -> pause(1));
                path.add(this :: setLiftDownA);
                path.add(() -> tilePointDrive(1.3, -1, a));
                path.add(() -> setSpeed(DriveMode.Sport));
                path.add(() -> tilePointDriveUnscaled(1, -1, a));
                visionParking(0, a);





        /*
        switch(visionAnalysis){
            case 0: path.add(() -> tilePointDrive(1.1, 1, 90)); break;
            case 1: path.add(() -> tilePointDrive(1.1, 0, 90)); break;
            case 2: path.add(() -> tilePointDrive(1.1, -1, 90)); break;
        }
        */
                //telemetry.addData("Auton Done!", visionAnalysis);
    }
}

