package frc.robot.subsystems;



import edu.wpi.first.wpilibj.XboxController;
import frc.robot.Constants.FlywheelConstants;
//import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Flywheel {
    


  public static enum FlywheelStates {
    OFF, IN, OUT
  }

  private FlywheelStates state = FlywheelStates.OFF;

  /**
   * Creates a new IntakeRollers.
   */
  public Flywheel() {
  
  }

  public void flywheelRun(XboxController controller, double power)
  {
    if (controller.getAButtonPressed())
    {
      shoot(power);
    }
    if (controller.getAButtonReleased())
    {
      stop();
    }
  }
  /**
   * shoots the flywheel at a given power
   * 
   * @param power the power to shoot the flywheel at [-1, 1]. Negative values spin outwards.
   */
  public void shoot(double power) {
    //flywheelMaster.set(ControlMode.PercentOutput, power);
  }

  /**
   * Stop the flywheel
   */
  public void stop() {
   // flywheelMaster.set(ControlMode.PercentOutput, 0);
  }


  public void setState(FlywheelStates istate) {
    state = istate;
  }

  public FlywheelStates getState() {
    return state;
  }

}
