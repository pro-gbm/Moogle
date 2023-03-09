import Stepper from './Stepper';
import { CONST } from '../../constants';

function SurveyHeader() {
  return (
    <div style={{ height: CONST.HEADERHEIGHT }}>
      <div style={{ marginTop: CONST.HEADERHEIGHT * 0.4, display: 'flex' }}>
        <Stepper />
        <Stepper />
        <Stepper />
        <Stepper />
        <Stepper />
      </div>
    </div>
  );
}

export default SurveyHeader;
