package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp(name = "ElDiablo")

public class ElDiablo extends LinearOpMode {

    private DcMotor motor1 = null;
    private DcMotor motor2 = null;
    private DcMotor motor3 = null;
    private DcMotor motor4 = null;
    private DcMotor motor5 = null;
    private DcMotor motor6 = null;
    private Servo servo1 = null;
    private Servo servo2 = null;

    @Override
    public void runOpMode() {

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        motor1 = hardwareMap.get(DcMotor.class,"motor1"); //frontleft, port 0
        motor2 = hardwareMap.get(DcMotor.class,"motor2");  //frontright, port 1
        motor3 = hardwareMap.get(DcMotor.class,"motor3"); //backleft, port 3
        motor4 = hardwareMap.get(DcMotor.class,"motor4");  //backright, port 2
        motor5 = hardwareMap.get(DcMotor.class, "motor5"); //carousel spinner
        motor6 = hardwareMap.get(DcMotor.class, "motor6"); //slide motor

        servo1 = hardwareMap.get(Servo.class, "servo1"); //servo intake right
        servo2 = hardwareMap.get(Servo.class, "servo2");

        motor1.setDirection(DcMotor.Direction.REVERSE);
        motor2.setDirection(DcMotor.Direction.FORWARD);
        motor3.setDirection(DcMotor.Direction.REVERSE);
        motor4.setDirection(DcMotor.Direction.FORWARD);

        motor6.setDirection(DcMotor.Direction.REVERSE);


        waitForStart();

        while (opModeIsActive()) {

            double m1Power;
            double m2Power;
            double m3Power;
            double m4Power;
            double m5Power;
            double m6Power;

            m1Power = -gamepad1.left_stick_y/2;
            m2Power = -gamepad1.right_stick_y/2;
            m3Power = -gamepad1.left_stick_y/2;
            m4Power = -gamepad1.right_stick_y/2;
            m5Power = gamepad2.left_stick_y;
            m6Power = -gamepad1.right_trigger+gamepad1.left_trigger;

            motor1.setPower(m1Power);
            motor2.setPower(m2Power);
            motor3.setPower(m3Power);
            motor4.setPower(m4Power);
            motor5.setPower(m5Power);
            motor6.setPower(m6Power);


            double G1rightStickY = -gamepad1.right_stick_y/2;
            double G1leftStickY = -gamepad1.left_stick_y/2;
            boolean G1rightBumper = gamepad1.right_bumper;
            boolean G1leftBumper = gamepad1.left_bumper;
            boolean G1Y = gamepad1.y;
            boolean G1B = gamepad1.b;
            boolean G1X = gamepad1.x;
            boolean G1A = gamepad1.a;
            double G1RT = -gamepad1.right_trigger;
            double G1LT = gamepad1.left_trigger;

            //int armup2 = 0;

            if (G1rightBumper) { //strafe right
                motor1.setPower(-.75);
                motor2.setPower(.75);
                motor3.setPower(.75);
                motor4.setPower(-.75);
            }

            else if (G1leftBumper) { //strafe left
                motor1.setPower(.75);
                motor2.setPower(-.75);
                motor3.setPower(-.75);
                motor4.setPower(.75);
            } /*else if (motor6.power == 0) {
                motor6.setPower(.1);

            } */else {
                motor1.setPower(G1leftStickY);
                motor2.setPower(G1rightStickY);
                motor3.setPower(G1leftStickY);
                motor4.setPower(G1rightStickY);
                motor6.setPower(G1RT);
                motor6.setPower(G1LT);

            }
/*
            if (G1B) {
                servo1.setPosition(.25);
                servo2.setPosition(.75); // continuously turn clockwise

            }else if (G1X) {
                servo1.setPosition(.75);
                servo2.setPosition(.25); // continuously turn counter clockwise

            } else if (G1A) {
                servo1.setPosition(.5);
                servo2.setPosition(.5);
            }

            //servo2 on right

            if (gamepad1.dpad_up) {
                motor5.setPower(.80);

            } else if (gamepad1.dpad_down) {
                motor5.setPower(-.80);

            } else {
                motor5.setPower(0);
            }

            /*if (gamepad1.right_bumper) {
                motor6.setPower(0.5);
            } else if (gamepad1.left_bumper) {
                motor6.setPower(-0.5);
            } else {
                motor6.setPower(0);
            }*/



            telemetry.addData("Status", "Running");
            telemetry.update();

        }
    }
}

