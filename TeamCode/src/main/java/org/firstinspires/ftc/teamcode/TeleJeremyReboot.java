package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name="TeleJeremyReboot", group="Linear Opmode")

public class TeleJeremyReboot extends LinearOpMode {

    private DcMotor motor1 = null;
    private DcMotor motor2 = null;
    private DcMotor motor3 = null;
    private DcMotor motor4 = null;
    private DcMotor duckyM = null;
    private DcMotor armTurner = null;
    //private DcMotor flapper = null;
    private DcMotor duckyM2 = null;
    private Servo betterFlapper = null;

    @Override
    public void runOpMode() {

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        motor1 = hardwareMap.get(DcMotor.class,"motor1"); //frontleft
        motor2 = hardwareMap.get(DcMotor.class,"motor2");  //frontright
        motor3 = hardwareMap.get(DcMotor.class,"motor3"); //backleft
        motor4 = hardwareMap.get(DcMotor.class,"motor4");  //backright
        duckyM = hardwareMap.get(DcMotor.class,"ducky");  //carousel
        armTurner = hardwareMap.get(DcMotor.class,"armTurner");  //arm armTurner
        //flapper = hardwareMap.get(DcMotor.class,"flapper");  //flapper
        duckyM2 = hardwareMap.get(DcMotor.class,"ducky2"); //carousel also
        betterFlapper = hardwareMap.get(Servo.class,"betterFlapper"); //servo flapper

        motor1.setDirection(DcMotor.Direction.REVERSE);
        motor2.setDirection(DcMotor.Direction.FORWARD);
        motor3.setDirection(DcMotor.Direction.REVERSE);
        motor4.setDirection(DcMotor.Direction.FORWARD);
        duckyM.setDirection(DcMotor.Direction.FORWARD);
        armTurner.setDirection(DcMotor.Direction.FORWARD);
        //flapper.setDirection(DcMotor.Direction.FORWARD);
        duckyM2.setDirection(DcMotor.Direction.FORWARD);
        //betterFlapper.setDirection(CRServo.Direction.FORWARD);

        waitForStart();

        while (opModeIsActive()) {

            double m1Power;
            double m2Power;
            double m3Power;
            double m4Power;

            m1Power = -gamepad1.right_stick_y * -.5;
            m2Power = -gamepad1.left_stick_y * -.5;
            m3Power = -gamepad1.right_stick_y * -.5;
            m4Power = -gamepad1.left_stick_y * -.5;

            motor1.setPower(m1Power);
            motor2.setPower(m2Power);
            motor3.setPower(m3Power);
            motor4.setPower(m4Power);

            double G1rightStickY = gamepad1.right_stick_y;
            double G1leftStickY = gamepad1.left_stick_y;
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

            //Strafe
            if (G1rightBumper) { //strafe right
                motor1.setPower(-1);
                motor2.setPower(1);
                motor3.setPower(1);
                motor4.setPower(-1);

            } else if (G1leftBumper) { //strafe left
                motor1.setPower(1);
                motor2.setPower(-1);
                motor3.setPower(-1);
                motor4.setPower(1);


                //Duck Spinner
            } else if (G1DPL) {  //spin counterclockwise
                duckyM.setPower(.7);
                duckyM2.setPower(-.7);
                sleep(1);
                duckyM.setPower(0);
                duckyM2.setPower(0);
/*
                //Intake
            } else if (gamepad1.a) {  //intake
                betterFlapper.setPosition(0.25);
            } else if (gamepad1.b) {   //outtake
                betterFlapper.setPosition(0.75);
            } else if (gamepad1.back) { //stop servo
                betterFlapper.setPosition(0.5);

                //Autonomous Stuff

            } else if (G1DPU) { //level 3
                resetEncoders();


                armTurner.setPower(.4);
                while(armTurner.getCurrentPosition() < 1000){
                    telemetry.addData("Arm", armTurner.getCurrentPosition());
                    telemetry.update();
                }
                armTurner.setPower(.001);
            } else if (G1DPR) { //level 2
                resetEncoders();


                armTurner.setPower(.4);
                while(armTurner.getCurrentPosition() < 700){
                    telemetry.addData("Arm", armTurner.getCurrentPosition());
                    telemetry.update();
                }
                armTurner.setPower(.001);

            }else if (G1DPD){

                resetEncoders();


                armTurner.setPower(.4);
                while(armTurner.getCurrentPosition() < 450){
                    telemetry.addData("Arm", armTurner.getCurrentPosition());
                    telemetry.update();
                }
                armTurner.setPower(.001);
            }else if (G1Y) {

                resetEncoders();


                armTurner.setPower(.4);
                while(armTurner.getCurrentPosition() < 200){
                    telemetry.addData("Arm", armTurner.getCurrentPosition());
                    telemetry.update();
                }
                armTurner.setPower(.001);
*/
                //Forward/Back
            } else {  //normal wheel movement
                motor1.setPower(G1rightTrigger * .4);
                motor2.setPower(G1rightTrigger * .4);
                motor3.setPower(G1rightTrigger * .4);
                motor4.setPower(G1rightTrigger * .4);
                motor1.setPower(G1leftTrigger * -.4);
                motor2.setPower(G1leftTrigger * -.4);
                motor3.setPower(G1leftTrigger * -.4);
                motor4.setPower(G1leftTrigger * -.4);

/*
            }  if (G1X) {  //arm down
                armTurner.setPower(-1);
                sleep(1);
                armTurner.setPower(0);
            }
*/
            telemetry.addData("Status", "Running");
            telemetry.update();

        }

    }/*
    private void resetEncoders(){
        //Reset Encoders

        armTurner.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        armTurner.setMode(DcMotor.RunMode.RUN_USING_ENCODER);*/
    }
}