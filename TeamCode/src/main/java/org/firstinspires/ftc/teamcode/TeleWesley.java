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

        @Override
        public void runOpMode() {

            telemetry.addData("Status", "Initialized");
            telemetry.update();

            motor1 = hardwareMap.get(DcMotor.class,"motor1"); //frontleft
            motor2 = hardwareMap.get(DcMotor.class,"motor2");  //frontright
            motor3 = hardwareMap.get(DcMotor.class,"motor3"); //backleft
            motor4 = hardwareMap.get(DcMotor.class,"motor4");  //backright

            motor1.setDirection(DcMotor.Direction.REVERSE);
            motor2.setDirection(DcMotor.Direction.FORWARD);
            motor3.setDirection(DcMotor.Direction.REVERSE);
            motor4.setDirection(DcMotor.Direction.FORWARD);

            waitForStart();

            while (opModeIsActive()) {

                double m1Power;
                double m2Power;
                double m3Power;
                double m4Power;

                // Forward and Backward (Left Stick)
                m1Power = -gamepad1.left_stick_y * -.5;
                m2Power = -gamepad1.left_stick_y * -.5;
                m3Power = -gamepad1.left_stick_y * -.5;
                m4Power = -gamepad1.left_stick_y * -.5;

                // Left and Right (Left Stick)
                m1Power = -gamepad1.left_stick_x * -.5;
                m2Power = -gamepad1.left_stick_x * -.5;
                m3Power = -gamepad1.left_stick_x * -.5;
                m4Power = -gamepad1.left_stick_x * -.5;

                motor1.setPower(m1Power);
                motor2.setPower(m2Power);
                motor3.setPower(m3Power);
                motor4.setPower(m4Power);

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
            }
    }
}