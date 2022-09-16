import Stepper from './Stepper';
import { CONST } from '../../constants';

function SurveyHeader() {
  return (
    <div
      style={{
        height: CONST.HEADERHEIGHT,
        backgroundColor: 'azure',
      }}
    >
      <div style={{ marginTop: '10px' }}>
        <Stepper />
        <Stepper />
        <Stepper />
        <Stepper />
      </div>
    </div>
  );
}

export default SurveyHeader;
