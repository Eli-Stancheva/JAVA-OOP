package p06_TirePressureMonitoringSystem;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runners.AllTests;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class AlarmTest {
    @Test
    public void testCheckWhenThresholdIsNormal(){
        Sensor sensor = Mockito.mock(Sensor.class);
        Alarm alarm = new Alarm(sensor);

        Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(19.3);
        alarm.check();
        Assert.assertFalse(alarm.getAlarmOn());
    }

    @Test
    public void testCheckWhenThresholdIsLower(){
        Sensor sensor = Mockito.mock(Sensor.class);
        Alarm alarm = new Alarm(sensor);

        Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(15.3);
        alarm.check();
        Assert.assertTrue(alarm.getAlarmOn());
    }

    @Test
    public void testCheckWhenThresholdIsHigh(){
        Sensor sensor = Mockito.mock(Sensor.class);
        Alarm alarm = new Alarm(sensor);

        Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(22.5);
        alarm.check();
        Assert.assertTrue(alarm.getAlarmOn());
    }
}
