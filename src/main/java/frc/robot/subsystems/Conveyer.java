package frc.robot.subsystems;


import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.Constants.ConveyerConstants;
//import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Conveyer {
    private TalonSRX conveyerMaster = new TalonSRX(ConveyerConstants.kConveyerID);
    private TalonSRX conveyerSlave = new TalonSRX(ConveyerConstants.kConveyerID2);

  public static enum ConveyerStates {
    OFF, IN, OUT
  }

  private ConveyerStates state = ConveyerStates.OFF;

  /**
   * Creates a new Conveyer.
   */
  public Conveyer() {
    conveyerSlave.follow(conveyerMaster);
    conveyerMaster.setNeutralMode(NeutralMode.Brake);
    

  }

  public void conveyerRun(XboxController controller, double power)
  {
    if (controller.getLeftBumperPressed())
    {
      index(power);
    }
    if (controller.getLeftBumperReleased())
    {
      stop();
    }
  }
  /**
   * spins the conveyer at a given power
   * 
   * @param power the power to spin the conveyer at [-1, 1]. Negative values spin outwards.
   */
  public void index(double power) {
    conveyerMaster.set(ControlMode.PercentOutput, power);
  }

  /**
   * Stop the conveyer
   */
  public void stop() {
    conveyerMaster.set(ControlMode.PercentOutput, 0);
  }


  public void setState(ConveyerStates istate) {
    state = istate;
  }

  public ConveyerStates getState() {
    return state;
  }

}
