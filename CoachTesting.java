package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "CoachTesting (Blocks to Java)")
public class CoachTesting extends LinearOpMode {

  private DcMotor FR;
  private DcMotor RR;
  private DcMotor FL;
  private DcMotor RL;

  /**
   * This sample contains the bare minimum Blocks for any regular OpMode. The 3 blue
   * Comment Blocks show where to place Initialization code (runs once, after touching the
   * DS INIT button, and before touching the DS Start arrow), Run code (runs once, after
   * touching Start), and Loop code (runs repeatedly while the OpMode is active, namely not
   * Stopped).
   */
  @Override
  public void runOpMode() {
    float LSY;
    float LSX;
    float RSY;
    float RSX;
    double FLP;
    double FRP;
    double RLP;
    double RRP;
    float LSY_Reverse;

    FR = hardwareMap.get(DcMotor.class, "FR");
    RR = hardwareMap.get(DcMotor.class, "RR");
    FL = hardwareMap.get(DcMotor.class, "FL");
    RL = hardwareMap.get(DcMotor.class, "RL");

    // Put initialization blocks here.
    waitForStart();
    if (opModeIsActive()) {
      // Put run blocks here.
      FR.setDirection(DcMotor.Direction.REVERSE);
      RR.setDirection(DcMotor.Direction.REVERSE);
      while (opModeIsActive()) {
        LSY = gamepad1.left_stick_y;
        LSY_Reverse = LSY * -1;
        LSX = gamepad1.left_stick_x;
        RSY = gamepad1.right_stick_y;
        RSX = gamepad1.right_stick_x;
        FLP = LSY_Reverse + LSX + RSX;
        FRP = (LSY_Reverse - LSX) - RSX;
        RLP = (LSY_Reverse - LSX) + RSX;
        RRP = (LSY_Reverse + LSX) - RSX;
        FL.setPower(FLP);
        FR.setPower(FRP);
        RL.setPower(RLP);
        RR.setPower(RRP);
        telemetry.addData("LeftStickY", LSY_Reverse);
        telemetry.addData("LeftStickX", LSX);
        telemetry.addData("RightStickY", RSY);
        telemetry.addData("RightStickX", RSX);
        telemetry.update();
        telemetry.addData("FLP", FLP);
        telemetry.addData("FRP", FRP);
        telemetry.addData("RLP", RLP);
        telemetry.addData("RRP", RRP);
      }
    }
  }
}