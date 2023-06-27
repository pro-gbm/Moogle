/** @jsxImportSource @emotion/react */
import { css } from '@emotion/react';

import Stepper from './Stepper';
import { CONST } from '../../constants';

const header = css({
  height: CONST.HEADERHEIGHT,
  '.steppers': {
    marginTop: CONST.HEADERHEIGHT * 0.4,
    display: 'flex',
  },
});

function SurveyHeader(props) {
  const { currentQuestion } = props;

  return (
    <div css={header}>
      <div className="steppers">
        {[...Array(4)].map((stepper, index) => (
          <Stepper flag={currentQuestion >= index + 1} key={index} />
        ))}
      </div>
    </div>
  );
}

export default SurveyHeader;
