/** @jsxImportSource @emotion/react */
import { css } from "@emotion/react";

import Stepper from "./Stepper";
import { CONST } from "../../constants";

const header = css({
  height: CONST.HEADERHEIGHT,
  ".steppers": {
    marginTop: CONST.HEADERHEIGHT * 0.4,
    display: "flex",
  },
});

function SurveyHeader() {
  return (
    <div css={header}>
      <div className="steppers">
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
