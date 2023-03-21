/** @jsxImportSource @emotion/react */
import { css } from '@emotion/react';

import { CONST } from '../../constants';

const footer = css({
  height: CONST.FOOTERHEIGHT,
  width: '100%',
  marginLeft: '50px',
  fontSize: '0.8rem',
  fontWeight: 'lighter',
  color: '#e6dedd',
  display: 'flex',
  alignItems: 'center',
  '.logo': {
    width: '50px',
    filter: 'grayscale(80%)',
  },
});

function SurveyFooter() {
  return (
    <div css={footer}>
      <img
        src={require('../../assets/turtle.png')}
        className="logo"
        alt="turtle"
      />
      <span>Copyright © 2023 pro-gbm All rights reserved.</span>
    </div>
  );
}

export default SurveyFooter;
