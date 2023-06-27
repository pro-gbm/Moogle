/** @jsxImportSource @emotion/react */
import { css } from '@emotion/react';

const stepper = css({
  marginLeft: '5px',
  marginRight: '5px',
  width: '10vw',
  minWidth: '50px',
  maxWidth: '100px',
  height: '5px',
});
function Stepper(props) {
  const { flag } = props;
  return (
    <div
      css={stepper}
      style={{ backgroundColor: flag ? '#f89d13' : '#d9d9d9' }}
    ></div>
  );
}

export default Stepper;
