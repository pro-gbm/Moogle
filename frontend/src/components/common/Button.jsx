/** @jsxImportSource @emotion/react */
import { css } from '@emotion/react';

import { useEffect, useState } from 'react';

/////////////// Type
// color: default, disabled, warning
// variant: outlined, filled
// size: small, medium, large
// value: any string
// icon: icon component
// iconPosition: front, back

/////////////// Color Chips
// #e6dedd
// #8f1d14
// #1b120f
// #f89d13

const parseProps = (variant, color, size) => {
  let text_color = '';
  let border_color = '';
  let bg_color = '';
  let padding = 0;
  let height = 0;
  let font_size = 0;
  let border_radius = 0;

  switch (size) {
    case 'small':
      padding = 5;
      height = 15;
      font_size = 12;
      border_radius = 9;
      break;
    case 'medium':
      padding = 8;
      height = 20;
      font_size = 17;
      border_radius = 12;
      break;
    case 'large':
      padding = 12;
      height = 25;
      font_size = 22;
      border_radius = 15;
      break;
    default:
      padding = 12;
      height = 25;
      font_size = 22;
      border_radius = 6;
  }

  switch (variant) {
    case 'outlined':
      if (color === 'warning') {
        text_color = '#8f1d14';
        border_color = '#8f1d14';
        bg_color = '#FFFFFF';
      } else if (color === 'disabled') {
        text_color = '#f2f2f2';
        border_color = '#f2f2f2';
        bg_color = '#FFFFFF';
      } else {
        text_color = '#f89d13';
        border_color = '#f89d13';
        bg_color = '#FFFFFF';
      }
      break;
    case 'filled':
      if (color === 'warning') {
        text_color = '#FFFFFF';
        border_color = '#8f1d14';
        bg_color = '#8f1d14';
      } else if (color === 'disabled') {
        text_color = '#FFFFFF';
        border_color = '#e6dedd';
        bg_color = '#e6dedd';
      } else {
        text_color = '#FFFFFF';
        border_color = '#f89d13';
        bg_color = '#f89d13';
      }
      break;
    default:
      text_color = '#FFFFFF';
      border_color = '#FFFFFF';
      bg_color = '#FFFFFF';
  }

  return {
    text_color: text_color,
    border_color: border_color,
    bg_color: bg_color,
    padding: padding,
    height: height,
    font_size: font_size,
    border_radius: border_radius,
  };
};

export default function Button(props) {
  const { color, size, value, variant, iconPosition } = props;
  const Icon = props.icon;

  const [feature, setFeature] = useState({
    text_color: '#FFFFFF',
    border_color: '#FFFFFF',
    bg_color: '#FFFFFF',
    padding: 8,
    height: 25,
    font_size: 22,
    border_radius: 6,
  });

  const buttonStyle = css({
    backgroundColor: feature.bg_color,
    border:
      variant === 'outlined' ? `2px solid ${feature.border_color}` : undefined,
    color: feature.text_color,
    marginBottom: '10px',
    padding: `${feature.padding}px`,
    paddingLeft: `calc(${feature.padding} * 7px)`,
    paddingRight: `calc(${feature.padding} * 7px)`,
    fontSize: `${feature.font_size}px`,
    borderRadius: `${feature.border_radius}px`,
    height: `${feature.height}px`,
    width: 'fit-content',
    whiteSpace: 'nowrap',
    fontWeight: 'bold',
    cursor: color !== 'disabled' ? 'pointer' : 'default',
    display: 'flex',
    alignItems: 'center',
    '&:hover': {
      boxShadow:
        color !== 'disabled'
          ? '3px 2px 5px rgba(0,0,0,0.15), inset 0 0 100px 100px rgba(255,255,255,0.2)'
          : undefined,
      transition: 'box-shadow 0.2s ease-out',
    },
    '.icon-front': {
      paddingRight: '5px',
    },
    '.icon-back': {
      paddingLeft: '5px',
    },
  });

  useEffect(() => {
    setFeature({
      text_color: parseProps(variant, color, size).text_color,
      border_color: parseProps(variant, color, size).border_color,
      bg_color: parseProps(variant, color, size).bg_color,
      padding: parseProps(variant, color, size).padding,
      height: parseProps(variant, color, size).height,
      font_size: parseProps(variant, color, size).font_size,
      border_radius: parseProps(variant, color, size).border_radius,
    });
  }, [variant, color, size]);

  return (
    <div className="icon-wrapper" css={buttonStyle}>
      {iconPosition === 'front' && Icon && (
        <div className="icon-front">
          <Icon fontSize="small" sx={{ cursor: 'inherit' }} />
        </div>
      )}
      {value.toUpperCase()}
      {iconPosition === 'back' && Icon && (
        <div className="icon-back">
          <Icon fontSize="small" sx={{ cursor: 'inherit' }} />
        </div>
      )}
    </div>
  );
}
