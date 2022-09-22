package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name="TeleWesley", group="LinearOpMode")

public class TeleWesley extends LinearOpMode {

    // Defining DC Motors
    private DcMotor motor1 = null;
    private DcMotor motor2 = null;
    private DcMotor motor3 = null;
    private DcMotor motor4 = null;
    private DcMotor motor1b = null;
    private DcMotor motor2b = null;
    private DcMotor motor3b = null;
    private DcMotor motor4b = null;

    @Override
    public void runOpMode() {

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        // Mapping Motors
        motor1 = hardwareMap.get(DcMotor.class,"frontLeft"); //frontleft
        motor2 = hardwareMap.get(DcMotor.class,"frontRight");  //frontright
        motor3 = hardwareMap.get(DcMotor.class,"backLeft"); //backleft
        motor4 = hardwareMap.get(DcMotor.class,"backRight");  //backright
        motor1b = hardwareMap.get(DcMotor.class,"frontLeft"); //frontleft
        motor2b = hardwareMap.get(DcMotor.class,"frontRight");  //frontright
        motor3b = hardwareMap.get(DcMotor.class,"backLeft"); //backleft
        motor4b = hardwareMap.get(DcMotor.class,"backRight");  //backright

        // Setting Directions
        motor1.setDirection(DcMotor.Direction.REVERSE);
        motor2.setDirection(DcMotor.Direction.FORWARD);
        motor3.setDirection(DcMotor.Direction.REVERSE);
        motor4.setDirection(DcMotor.Direction.FORWARD);
        motor1b.setDirection(DcMotor.Direction.REVERSE);
        motor2b.setDirection(DcMotor.Direction.FORWARD);
        motor3b.setDirection(DcMotor.Direction.REVERSE);
        motor4b.setDirection(DcMotor.Direction.FORWARD);

        waitForStart();

        while (opModeIsActive()) {

            double m1xPower;
            double m2xPower;
            double m3xPower;
            double m4xPower;
            double m1yPower;
            double m2yPower;
            double m3yPower;
            double m4yPower;

            double G1rightStickY = gamepad1.right_stick_y;
            double G1leftStickY = gamepad1.left_stick_y;
            double G1rightStickX = gamepad1.right_stick_x;
            double G1leftStickX = gamepad1.left_stick_x;
            double G1rightTrigger = -gamepad1.right_trigger;
            double G1leftTrigger = -gamepad1.left_trigger;
            boolean G1rightBumper = gamepad1.right_bumper;
            boolean G1leftBumper = gamepad1.left_bumper;
            boolean G1Y = gamepad1.y;
            boolean G1B = gamepad1.b;
            boolean G1X = gamepad1.x;
            boolean G1A = gamepad1.a;
            boolean G1back = gamepad1.back;
            boolean G1DPR = gamepad1.dpad_right;
            boolean G1DPL = gamepad1.dpad_left;
            boolean G1DPU = gamepad1.dpad_up;
            boolean G1DPD = gamepad1.dpad_down;
    /*
            // Forward and Backward (Left Stick)
            m1yPower = -gamepad1.left_stick_y * -1;
            m2yPower = -gamepad1.left_stick_y * 1;
            m3yPower = -gamepad1.left_stick_y * 1;
            m4yPower = -gamepad1.left_stick_y * 1;
            motor1.setPower(m1yPower);
            motor2.setPower(m2yPower);
            motor3.setPower(m3yPower);
            motor4.setPower(m4yPower);

            // Left and Right (Left Stick)
            m1xPower = -gamepad1.left_stick_x * 1;
            m2xPower = -gamepad1.left_stick_x * 1;
            m3xPower = -gamepad1.left_stick_x * 1;
            m4xPower = -gamepad1.left_stick_x * -1;
            motor1b.setPower(m1xPower);
            motor2b.setPower(m2xPower);
            motor3b.setPower(m3xPower);
            motor4b.setPower(m4xPower);
    */
            if (G1DPU) {
                motor1.setPower(.65);
                motor2.setPower(.65);
                motor3.setPower(.65);
                motor4.setPower(.65);
            } else if (G1DPD) {
                motor1.setPower(-.65);
                motor2.setPower(-.65);
                motor3.setPower(-.65);
                motor4.setPower(-.65);
            } else if (G1DPL) {
                motor1.setPower(-.65);
                motor2.setPower(.65);
                motor3.setPower(.65);
                motor4.setPower(-.65);
            } else if (G1DPR) {
                motor1.setPower(.65);
                motor2.setPower(-.65);
                motor3.setPower(-.65);
                motor4.setPower(.65);
            }
            // Turning
            m1xPower = -gamepad1.right_stick_x * -.5;
            m2xPower = -gamepad1.right_stick_x * .5;
            m3xPower = -gamepad1.right_stick_x * -.5;
            m4xPower = -gamepad1.right_stick_x * .5;
            motor1b.setPower(m1xPower);
            motor2b.setPower(m2xPower);
            motor3b.setPower(m3xPower);
            motor4b.setPower(m4xPower);

            m1xPower = -gamepad1.left_stick_x * -.99;
            m2xPower = -gamepad1.left_stick_x * .99;
            m3xPower = -gamepad1.left_stick_x * -.99;
            m4xPower = -gamepad1.left_stick_x * .99;
            motor1b.setPower(m1xPower);
            motor2b.setPower(m2xPower);
            motor3b.setPower(m3xPower);
            motor4b.setPower(m4xPower);
        }
    }
}